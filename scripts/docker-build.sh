tag="${GITHUB_SHA:0:8}"
echo "$tag"

#inloggen docker io repo
docker login -u $username -p $password
docker build . -t $username/tweet-repo:$tag -t $username/tweet-repo:latest
docker push $username/tweet-service:$tag
docker push $username/tweet-service:latest