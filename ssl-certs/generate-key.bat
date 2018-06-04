echo 1 generate root CA
keytool -genkey -alias servicehive-ca -dname "CN=servicehive,OU=devcloud,O=2012LAB,L=Shenzhen,ST=Guangdong,C=CN"  -storetype PKCS12 -keyalg RSA -keysize 2048  -validity 3650 -keystore servicehive.jks -storepass 123456

echo 2 generate certification with root CA
keytool -genkeypair -alias eureka-server -dname "CN=eureka-server,OU=devcloud,O=2012LAB,L=Shenzhen,ST=Guangdong,C=CN"  -storetype PKCS12 -keyalg RSA -keysize 2048  -validity 3650 -keystore servicehive.jks -storepass 123456 -ext san=dns:eureka-server1,dns:eureka-server2,dns:eureka-server1.svc.local,dns:eureka-server2.svc.local,dns:svc.local,dns:localhost,ip:127.0.0.1
keytool -certreq -alias eureka-server -file eureka-server.csr -keystore servicehive.jks -storepass 123456
keytool -gencert -alias servicehive-ca -infile eureka-server.csr -outfile eureka-server.cer -validity 3650 -keystore servicehive.jks -storepass 123456 -ext san=dns:eureka-server1,dns:eureka-server2,dns:eureka-server1.svc.local,dns:eureka-server2.svc.local,dns:svc.local,dns:localhost,ip:127.0.0.1

keytool -genkeypair -alias eureka-client -dname "CN=eureka-client,OU=devcloud,O=2012LAB,L=Shenzhen,ST=Guangdong,C=CN"  -storetype PKCS12 -keyalg RSA -keysize 2048  -validity 3650 -keystore servicehive.jks -storepass 123456 -ext san=dns:eureka-client,dns:eureka-client.svc.local,dns:svc.local,dns:localhost,ip:127.0.0.1
keytool -certreq -alias eureka-client -file eureka-client.csr -keystore servicehive.jks -storepass 123456
keytool -gencert -alias servicehive-ca -infile eureka-client.csr -outfile eureka-client.cer -validity 3650 -keystore servicehive.jks -storepass 123456 -ext san=dns:eureka-client,dns:eureka-client.svc.local,dns:svc.local,dns:localhost,ip:127.0.0.1

echo 3 import certifications to jssecacerts
keytool -import -alias eureka-server -file eureka-server.cer -keystore jssecacerts -storepass changeit
keytool -import -alias eureka-client -file eureka-client.cer -keystore jssecacerts -storepass changeit