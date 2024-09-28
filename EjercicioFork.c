#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main(){

	pid_t pid, hijo_pid;
	int variable = 6;
	printf("Valor inicial de la variable: %d\n", variable);
	pid = fork();
	if(pid == -1){    //Ha ocurrido un error
	printf("Ha ocurrido un error");
	}
	if(pid == 0){    //Nos encontramos en el proceso hijo
	variable -= 5;
	printf("Variable en Proceso Hijo: %d\n", variable);
	}
	else{    //Nos encontramos en el proceso padre
	variable += 5;
	hijo_pid = wait(NULL);
	printf("Variable en Proceso Padre: %d\n", variable);
	}
	exit(0);

}
