isSynchronizedData=$1
isCreateReport=$2
date=`cat date.txt |cut -d : -f1`
time=`cat date.txt |cut -d : -f2`
currentPath=`pwd`

cd ${currentPath}/tools
java -jar GenerateTestNgReport.jar C:\Users\dell\Desktop\AutoTest/output/20160427/1525 ${isSynchronizedData} ${isCreateReport}