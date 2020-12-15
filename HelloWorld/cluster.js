var cluster = require("cluster");

//Round Robin 방식으로 스케쥴링
cluster.schedualingPolicy = cluster.SCHED_RR;

if(cluster.isMaster == true)
{
	cluster.fork();
	cluster.fork();
	cluster.fork();
	
	cluster.on('online', function(worker){
		for(var i=0; i<10; i++){
			console.log(worker.process.pid, '동작');
		}
	});
}