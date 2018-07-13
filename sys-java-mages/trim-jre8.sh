#解压
tar xvf jre-8u171-linux-x64.tar.gz
mv jre1.8.0_171 jre8

cd jre8

#删除文本文件
rm -rf COPYRIGHT LICENSE README release THIRDPARTYLICENSEREADME-JAVAFX.txt THIRDPARTYLICENSEREADME.txt Welcome.html

#删除其他无用文件
rm -rf     lib/plugin.jar \
           lib/ext/jfxrt.jar \
           bin/javaws \
           lib/javaws.jar \
           lib/desktop \
           plugin \
           lib/deploy* \
           lib/*javafx* \
           lib/*jfx* \
           lib/amd64/libdecora_sse.so \
           lib/amd64/libprism_*.so \
           lib/amd64/libfxplugins.so \
           lib/amd64/libglass.so \
           lib/amd64/libgstreamer-lite.so \
           lib/amd64/libjavafx*.so \
           lib/amd64/libjfx*.so

#重新打包所有文件
cd ..
tar zcvf jre8.tar.gz jre8