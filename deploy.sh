
PEM_PATH="/Users/lukaszdutka/pokemon-backend-ec2-true-key.pem"
EC2_URL="ec2-user@3.254.210.195"

ssh -i $PEM_PATH $EC2_URL "sudo kill \$(sudo lsof -ti:443)"
#ssh -i $PEM_PATH $EC2_URL "sudo lsof -ti:443 | xargs kill -15"

mvn clean install

scp -i $PEM_PATH ./target/pokemon-rater-backend-0.0.1-SNAPSHOT.jar $EC2_URL:~/application.jar

ssh -i $PEM_PATH $EC2_URL "sudo ./run.sh"