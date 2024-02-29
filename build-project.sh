docker build -t taco
docker stop taco || true
docker rm taco || true
docke run -d -p 8080:8080 --name taco taco