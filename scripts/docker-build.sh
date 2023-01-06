tag="$GITHUB_SHA:0:8"
echo "$tag"

#inloggen docker io repo
docker login -u $DOCKER_USER -p $DOCKER_PASSWORD
docker build . -t $DOCKER_USER/tweet-repo:$tag -t $DOCKER_USER/tweet-repo:latest
docker push $DOCKER_USER/tweet-service:$tag
docker push $DOCKER_USER/tweet-service:latest