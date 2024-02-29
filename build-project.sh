docker build -t MusicLibryCopy .
docker stop MusicLibryCopy || true
docker rm MusicLibryCopy || true
docke run -d -p 8080:8080 --name MusicLibryCopyMusicLibryCopy