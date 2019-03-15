PID=pid
# 启动admin
if [ -f "$PID" ] && kill -0 $(cat "$PID"); then
	echo "=========进程在运行。。。准备杀死"
	PID="$(cat "$PID")"
	kill -9 $PID
	rm -rf "$PID"
	echo "=========进程kill完成,准备启动==========="
fi
nohup java -jar -Xms200m -Xmx256m  ./target/huanyuofficial-0.0.1.jar --spring.profiles.active=prod>> logs/nohup.out 2>&1 & echo $! > $PID
echo "=========启动完成========="