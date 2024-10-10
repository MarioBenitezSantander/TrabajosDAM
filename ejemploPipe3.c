#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void){
	int fd[2];
	pid_t pid;
	char saludoPadre[] = "Buenos días hijo.\0";
	char buffer[80];

	pipe(fd); // Creo el pipe
	pid = fork(); // Creo el proceso

	switch(pid){
		case -1: // Error
			printf("No se ha podido crear el proceso hijo...");
			exit(-1);
		case 0: // Hijo recibe mensaje
			close(fd[1]); // Cierra la escritura
			read(fd[0], buffer, sizeof(buffer)); // Leo el pipe
			printf("\tEl hijo recibe datos del pipe: %s\n", buffer);
			break;
		default:
			close(fd[0]); // Cierra la lectura
			write(fd[1], saludoPadre, strlen(saludoPadre)); //Escribe en el pipe
			printf("El padre envia mensaje al hijo...\n");
			wait(NULL); // Espero al proceso hijo
			break;
	}
	return 0;
}
