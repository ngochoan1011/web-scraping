NODE_MODULES="/node_modules"
RESOURCES="../src/main/resources"

cd client;
[[ ! -d $NODE_MODULES ]] && npm install
[[ ! -d $RESOURCES ]] && mkdir $RESOURCES
npm run build
cd ../
rm -rf target 
mvn spring-boot:run 
