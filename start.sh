start() {

  kill -9 $(lsof -t -i:8080)

  cd backend
  mvn spring-boot:run &
  pid1=$!

  cd ../front
  npm run dev &
  pid2=$!

  wait $pid1 $pid2
}

stop() {
  kill $pid1
  kill $pid2
}

start