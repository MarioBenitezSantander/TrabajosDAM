#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void main(){
	pid_t pid, pid_hijo1, pid_hijo2, pid_hijo3;
	pid = fork();
	switch(pid){
		case -1:
			printf("Error al crear el proceso hijo");
			exit(-1);
		case 0:
			printf("Soy el hijo = 1. Mi padre es = %d, mi PID = %d\n", getppid(), getpid());
			break;
		default:
			pid_hijo1 = wait(NULL);
			pid = fork();
			switch(pid){
				case -1:
					printf("Error al crear el proceso hijo");
                       		 	exit(-1);
				case 0:
					printf("Soy el hijo = 2. Mi padre es = %d, mi PID = %d\n", getppid(), getpid());
                        		break;
				default:
					pid_hijo2 = wait(NULL);
					pid = fork();
					switch(pid){
						case -1:
							printf("Error al crear el proceso hijo");
		                                        exit(-1);
						case 0:
							printf("Soy el hijo = 3. Mi padre es = %d, mi PID = %d\n", getppid(), getpid());
		                                        break;
						default:
							pid_hijo3 = wait(NULL);
							printf("Proceso padre = %d\n", getpid());
					}
			}

	}
}
