#include <stdio.h>
#include "print_tokens2.c"
#include <io.h>
#include <time.h>
#include <stdlib.h>

int main(void)
{

    struct _finddata_t c_file;
    long hFile;
    char filename[5000][20];
    int i=0;

    /* Find first .c file in current directory */
    if( (hFile = _findfirst( "*.*", &c_file )) == -1L )
     printf( "No files in current directory!\n" );
   else
   {


     /* Find the rest of the .c files */
     while( _findnext( hFile, &c_file ) == 0 )
     {

     //printf( " %s\n",c_file.name);
     strcpy(filename[i], c_file.name);
     
     //printf( "%s\n",filename[i]);
     i++;
     //filename[]=&c_file.name;
     }
     

     _findclose( hFile );
   }
   int totalstate[12];
   i=0;
         for (i=0;i<12;i++);
          totalstate[i]=0;
          
   int filenumber=0;
   int j=0;
   int *state;
   for (j=0;j<100;j++)
   {
   filenumber=rand()%5000;
   //printf( "%d %s\n",filenumber,filename[filenumber]);
   
   
   //printf("Hello, world!\n");
   //test2("bug6.123.1");
   //system("pause");
   state=print_tokens(0,filename[filenumber]);
   //i=0;
    //     for (i=0;i<26;i++)
     //        printf("%d ",state[i]);
     i=0;
     for (i=0;i<6;i++)
     {
         if (state[i]==1)
            totalstate[2*i]=1;
            else
            totalstate[2*i+1]=1;
      }               
   }
   i=0;
  
   int k=0,m=0;
   int cases=100;
         for (i=0;i<12;i++)
         {
          if (totalstate[i]==0)
          {
             while(1)
             {
              filenumber=rand()%5000;
              state=print_tokens(0,filename[filenumber]);
              
     //                          for (m=0;m<14;m++)
    //  printf("%d ",totalstate[m]);
              
              
              cases++;
                   for (k=0;k<6;k++)
                   {
                           if (state[k]==1)
                              totalstate[2*k]=1;
                           else
                               totalstate[2*k+1]=1;
                               }  
              if (totalstate[i]==1)
                 break;

              }

          }
          }
          
         
  // for (i=0;i<12;i++)
   //   printf("%d ",totalstate[i]);
  // printf("\ntest cases : %d\n",cases);
   system("pause");
   return 0;
}
