FROM clojure:alpine
WORKDIR /usr/src/app
COPY . .
RUN lein deps
EXPOSE 3000
CMD [ "lein", "run" ]