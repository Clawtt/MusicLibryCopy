docker build -t music .
docker stop music || true
docker rm music || true
docker run -d -p 8080:8080 --name=music music