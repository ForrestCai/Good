
deploymentCount=`kubectl get deployment |wc |awk '{print $1}'`

for((i=2;i<=$deploymentCount;i++));do
    deployment=`kubectl get deployment |awk 'NR=='$i'{print $1}'`
    ver=`kubectl get deployment -o yaml -l app=$deployment |grep image:`
    ver=`echo $ver | awk -F "/" '{print $NF}'`
    echo $deployment: $ver
done;

