PEM_PATH="/Users/lukaszdutka/pokemon-backend-ec2-true-key.pem"
EC2_URL="ec2-user@3.254.210.195"

rsync -avz -e "ssh -i $PEM_PATH" "$EC2_URL:/home/ec2-user/poke-rater.db" "./poke-rater.db"