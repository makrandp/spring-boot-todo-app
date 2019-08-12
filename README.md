# Java Spring boot app using docker with hot reload

## Setup
- `docker-compose up --force-recreate`
- In Eclipse:
  - Go to Run -> Run Configurations -> Java Application -> New
  - Choose `org.springframework.boot.devtools.RemoteSpringApplication` as the `main class`
  - Choose `todo-app` as the project
  - Set http://localhost:8080 to program arguments

## Useful Commands
- `docker-compose up --force-recreate -d`
- `docker-compose start`
- `docker-compose stop`
- `docker-compose down --rmi all`

## APIs
- `curl --request GET --url http://localhost/todo`
- `curl --request POST \
    --url http://localhost/todo \
    --header 'content-type: application/json' \
    --data '{
  	"title" : "Title",
  	"description" : "Description"
  }'`
- `curl --request PUT \
    --url http://localhost/todo/1 \
    --header 'content-type: application/json' \
    --data '{
  	"title": "Modified Title",
  	"description": "Modified Description"
  }'`
- `curl --request DELETE \
    --url http://localhost/todo/1`
