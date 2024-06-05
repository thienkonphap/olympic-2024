#!/bin/bash

# Function to check if kubectl is installed
check_kubectl() {
    if ! [ -x "$(command -v kubectl)" ]; then
        echo 'Error: kubectl is not installed.' >&2
        exit 1
    fi
}
# Function to build Docker image
build_docker_image() {
    echo "Building Docker image..."
    eval $(minikube -p minikube docker-env)
    docker build -t sites-service-container:latest .
}
# Function to check if minikube is running
check_minikube() {
    if ! minikube status | grep -q 'host: Running'; then
        echo 'Minikube is not running. Starting Minikube...'
        minikube start
    fi
}

# Function to apply Kubernetes configuration files
apply_k8s_configs() {
    echo "Applying Kubernetes configuration files..."
    kubectl apply -f pod.yaml
    kubectl apply -f deployment.yaml
    kubectl apply -f service.yaml
}

# Function to check the status of the deployed resources
check_status() {
    echo "Checking the status of the deployed resources..."
    kubectl get pods
    kubectl get deployments
    kubectl get services
}

# Main script execution
main() {
    check_kubectl
    check_minikube
    build_docker_image
    apply_k8s_configs
    check_status
    echo "Deployment to Minikube completed successfully."

    # Run your application
    minikube service spring-app-service
}

# Run the main function
main
