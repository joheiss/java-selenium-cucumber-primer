# Build the image
docker build -t jenkins-selenium-2025 .

# Run the container
docker run -d -p 8080:8080 -p 50000:50000 --name jenkins-ci jenkins-selenium-2025
