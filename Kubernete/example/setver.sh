repository='{repositoryplaceholder}'

if [ x$1 != x ]
then
	repository=$1
fi

deploymentCount=`kubectl get deployment |wc |awk '{print $1}'`
imageString='- image'
for((i=2;i<=$deploymentCount;i++));do
    deployment=`kubectl get deployment |awk 'NR=='$i'{print $1}'`
    ver=`kubectl get deployment -o yaml -l app=$deployment |grep image:`
    ver=`echo $ver | awk -F "/" '{print $NF}'`
    echo kubectl set image deployment/$deployment $deployment=$repository/$ver >> upgrade.sh
done;
