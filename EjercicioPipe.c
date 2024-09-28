#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(){

	int fd[2];
	char buffer[30];
	pid_t pid;

	pipe(fd);       //Creación del pipe de comunicación
	pid = fork();   //Creación del proceso hijo

	switch(pid){
		case -1:  //Error al crear el proceso hijo
		  printf("No se ha podido crear el hijo");
		  exit(-1);
		  break;
		case 0:  //Estamos en el proceso hijo
		  printf("El hijo envía algo al pipe\n");
		  write(fd[1], "Buenos días, padre", 19);
		  break;
		default:  //Estamos en el proceso padre
		  wait(NULL);
		  read(fd[0], buffer, 19);
		  printf("El padre recibe algo del pipe: %s\n", buffer);
		  break;
	}

}
