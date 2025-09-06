
Deploymnet on Kubernetes

1. Create a namespace
   kubectl create namespace bankapp
2. Create a secret for mysql password
   kubectl create secret generic mysql-pass --from-literal=password=root -n bankapp
3. Create a configmap for application properties
   kubectl create configmap bankapp-config --from-file=./k8s/config -n bankapp
4. Apply the deployments and services
   kubectl apply -f ./k8s/mysql -n bankapp
   kubectl apply -f ./k8s/configserver -n bankapp
   kubectl apply -f ./k8s/accounts -n bankapp
   kubectl apply -f ./k8s/loans -n bankapp
   kubectl apply -f ./k8s/cards -n bankapp
5. Verify the deployments and services
   kubectl get all -n bankapp
6. Access the services
   http://<node-ip>:<node-port>/accounts
   http://<node-ip>:<node-port>/loans
   http://<node-ip>:<node-port>/cards

Reference:
  docker compose up - will create the containers if they don't exist
  docker compose start - will start existing containers
  docker compose stop - will stop running containers
  docker compose down - will stop and remove containers, networks, images, and volumes
  docker compose restart - will restart running containers
  docker compose logs - will show logs from containers
  docker compose ps - will list containers
  docker compose exec <service> <command> - will run a command in a running container

  
  docker ps 
  docker ps -a - will list all containers
  docker images - will list all images
  docker image inspect <image> - will show detailed information about an image
  docker image rm <image> - will remove an image
  docker container rm <container> - will remove a container
  docker build -t <image_name> . - will build an image from a Dockerfile in the current directory
  docker run -p <host_port>:<container_port> <image> - will run a container from an image and map ports
  docker container logs <container> - will show logs from a container
  docker container start <container> - will start a stopped container
  docker container stop <container> - will stop a running container
  docker container pause <container> - will pause a running container
  docker container kill <container> - will kill a running container
  docker container restart <container> - will restart a running container
  docker container inspect <container> - will show detailed information about a container

    docker continer logs -f <container> - will follow logs from a container
    docker rm -f <container> - will force remove a running container
    docker container rm
    docker container prune - will remove all stopped containers
    docker image prune - will remove all unused images
    docker image push <image> - will push an image to a registry
    docker image pull <image> - will pull an image from a registry
    docker system prune - will remove all unused data
    docker container stats <container> - will show resource usage statistics for a container
    docker rmi -f <image> - will force remove an image
    docker login - will log in to a registry
    docker logout - will log out from a registry
    docker history <image> - will show the history of an image
    docker inspect <container|image> - will show detailed information about a container or image
    docker top <container> - will show the running processes in a container
    docker history <image> - will show the history of an image
    docker exec -it <container> /bin/bash - will open a bash shell in a running container
    docker compose up
    docker compose down

FOr Mysql Database

