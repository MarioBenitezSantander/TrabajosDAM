#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <fcntl.h>

void manejador(int signal){
	printf("Padre recibe señal..%d\n", signal);
}

int main(){
	int pid_hijo;
	int pid;
	pid = getpid();
	pid_hijo = fork();
	switch(pid_hijo){
		case -1:
			printf("Error al crear el proceso hijo...\n");
			exit(-1);
		case 0:
			sleep(1);
			kill(pid, SIGUSR1);
			sleep(1);
                        kill(pid, SIGUSR1);
                        sleep(1);
                        kill(pid, SIGUSR1);
                        sleep(1);
			kill(pid, SIGKILL);
			sleep(1);
			break;
		default:
			signal(SIGUSR1, manejador);
			while(1){
			};
			break;
	}
	return 0;
}
