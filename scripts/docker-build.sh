tag="${GITHUB_SHA}"
echo "$tag"

#inloggen docker io repo
docker login -u $username -p $password
docker build . -t "$username/tweet-service:$tag"
docker images
docker push "$username/tweet-service:$tag"