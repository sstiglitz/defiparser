# Parsing Service

Proof of concept for parsing event updates from a vendor into database tables.

## To Run

Run the following from command line

```
$ ./gradlew build
```

Go to `/build/libs` to grab the packaged .jar file. Then run the .jar file.

## To Test

Run the following to post the example.xml.

```
$ curl -X POST -H "Content-Type: text/plain" -d "@example.xml" http://localhost:8080/defi
```

It will write to the H2 database. You can view the contents of the H2 database by going to `http://localhost:8080/h2-console`
