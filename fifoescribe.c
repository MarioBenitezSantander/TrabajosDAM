#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	int fp;
	char saludo[] = "Un saludo!!!\n";

	fp = open("FIF02", 1);

	if(fp == -1){
		printf("Error al abrir el fichero...");
		exit(1);
	}
	printf("Mandando información al fifo...\n");
	write(fp, saludo, strlen(saludo));
	close(fp);
	return 0;
}
