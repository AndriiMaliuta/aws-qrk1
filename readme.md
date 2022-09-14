https://quarkus.io/guides/amazon-lambda

```bash
mvn archetype:generate \
       -DarchetypeGroupId=io.quarkus \
       -DarchetypeArtifactId=quarkus-amazon-lambda-archetype \
       -DarchetypeVersion=2.12.1.Final
```

```
quarkus build 
./mvnw clean package
./gradlew build
```

```
LAMBDA_ROLE_ARN="arn:aws:iam::1234567890:role/lambda-role"
./target/manage.sh create
./target/manage.sh update
./target/manage.sh invoke
# SAM
sam local invoke --template target/sam.jvm.yaml --event payload.json
```
### Native
```
./mvnw package -Dnative
./mvnw package -Dnative -Dquarkus.native.container-build=true
--environment 'Variables={DISABLE_SIGNAL_HANDLERS=true}'
```