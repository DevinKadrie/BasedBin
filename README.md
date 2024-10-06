# Basedbin

## Run Project

```shell
# In the root of the project, any terminal
source .venv/Scripts/activate
localstack start -d
awslocal s3api create-bucket --bucket pastes
awslocal s3api put-bucket-cors --bucket pastes --cors-configuration file://cors-config.json

# In the backend terminal and directory
export AWS_ACCESS_KEY_ID="test"
export AWS_SECRET_ACCESS_KEY="test"
./gradelw run

# In the frontend terminal and directory
bun run dev
```

## To Do

- [x] Use UUID for primary keys
- [ ] Set up docker compose
- [ ] Change postgres to use a fixed port
- 
