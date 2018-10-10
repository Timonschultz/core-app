@echo off
echo Removes old postgres DB (if present) and starts new one
pause
docker kill mypostgres
docker rm mypostgres
pause
docker run -p 5432:5432 --name mypostgres -e POSTGRES_PASSWORD=mysecretpassword postgres
pause