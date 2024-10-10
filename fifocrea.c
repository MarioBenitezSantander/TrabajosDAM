#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(void){
	int fp;
	int p, bytesleidos;
	char saludo[]= "Un saludo!!!\n", buffer[10];

	p=mkfifo("FIF02", S_IFIFO|0666); //Permiso de lectura y escritura

	if(p==-1){
		printf("Ha ocurrido un error...\n");
		exit(0);
	}
	while(1){
		fp = open("FIF02", 0);
		bytesleidos = read(fp, buffer, 1);
		printf("Obteniendo información...");
		while(bytesleidos!=0){
			printf("%1c", buffer[0]); // Pinto el byte leido
			bytesleidos = read(fp, buffer, 1); //Leo otro byte
		}
		close(fp);
	}
	return(0);
}
