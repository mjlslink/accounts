echo "# docker-compose" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/mjlslink/docker-compose.git
git push -u origin main

…or push an existing repository from the command line

git remote add origin https://github.com/mjlslink/docker-compose.git
git branch -M main
git push -u origin main

Make an admin user for the dashboard
kubectl apply -f dashboard-adminuser.yml
To asociate the user with the role:
kubectl apply -f dashboard-rolebinding.yml

To get the token for dashboard login:
kubectl -n kubernetes-dashboard create token admin-user

Generate a long-lived token for the admin user first create a secret (secret.yml)

Then execute the following command to create a long-lived token:
kubectl apply -f secret.yml

And get the token with:
kubectl -n kubernetes-dashboard get secret admin-user-token -o jsonpath="{.data.token}" 

This creates
ZXlKaGJHY2lPaUpTVXpJMU5pSXNJbXRwWkNJNklsSkZVbTFYWVRWdk5qTnpZelpQWlRGQ1dtOXVVa2d3ZVRWd1dHeHhZV1pHU2pKT1VHUjJNa3RGVm1zaWZRLmV5SnBjM01pT2lKcmRXSmxjbTVsZEdWekwzTmxjblpwWTJWaFkyTnZkVzUwSWl3aWEzVmlaWEp1WlhSbGN5NXBieTl6WlhKMmFXTmxZV05qYjNWdWRDOXVZVzFsYzNCaFkyVWlPaUpyZFdKbGNtNWxkR1Z6TFdSaGMyaGliMkZ5WkNJc0ltdDFZbVZ5Ym1WMFpYTXVhVzh2YzJWeWRtbGpaV0ZqWTI5MWJuUXZjMlZqY21WMExtNWhiV1VpT2lKaFpHMXBiaTExYzJWeUlpd2lhM1ZpWlhKdVpYUmxjeTVwYnk5elpYSjJhV05sWVdOamIzVnVkQzl6WlhKMmFXTmxMV0ZqWTI5MWJuUXVibUZ0WlNJNkltRmtiV2x1TFhWelpYSWlMQ0pyZFdKbGNtNWxkR1Z6TG1sdkwzTmxjblpwWTJWaFkyTnZkVzUwTDNObGNuWnBZMlV0WVdOamIzVnVkQzUxYVdRaU9pSXhOV00zWVRJd1l5MWpNalUxTFRRMFlUSXRZVFZqWXkxbU9EaGlZMk01TjJVNVl6QWlMQ0p6ZFdJaU9pSnplWE4wWlcwNmMyVnlkbWxqWldGalkyOTFiblE2YTNWaVpYSnVaWFJsY3kxa1lYTm9ZbTloY21RNllXUnRhVzR0ZFhObGNpSjkuV0M5NmFaVTlpcFJwZDR1aHFITG95OEtzbk1Ick5HSTdCYjFGNDU5Nk1vN0pfTHc2Yng3OTlEVldOSlNXNl80cXNuUHU0OWk4Q25uVTBYU0MzcGpGZU9udXRaLVdjOFdvQlZYNzNHeG4xckg1NUo2ckhQTkxxU2RkUTc5MjZxQ1JxWUZsOEZSUkhEeU1XalFrRThiZmtBY1JLYUt2NnJGRnV0eUJHUXNqdFhNb2ZGWU9NX3VJTW1RNWNTRGRaX093YjkzRFBKdGlpbEtZYkN3dlJPRjBtakMtMi1xYzVSR0tTNkc4UXg1QTZ0bFc4aU1CUUExMzdmYnZVYnhWb3A3MjltaXVJUlFHd2VIdmwxN1R0ZkJhcHpxLUlBZlBSVGc0VnJuTzR1b05MSjZTYXNxNzhSc3FvLUM5N0xVQVE0VGNIZ2VhbkwyZ0pQZDU1YUdfd1BjNl9n

kubectl -n kubernetes-dashboard get svc
kubectl apply -f dashboard-adminuser.yml

Once the token is available

kubectl -n kubernetes-dashboard port-forward svc/kubernetes-dashboard-kong-proxy 8443:443

This will start a proxy that forwards traffic from your local machine's port 8443 to
the Kubernetes Dashboard service's port 443.

Deployment

Configserver
kubectl apply -f configserver.yml
COnfigMaps
kubectl apply -f configmaps.yml
