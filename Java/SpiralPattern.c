#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

int main(int argc, char **argv) {
    int n = 0;
    if (argc > 1) {
        char *end;
        errno = 0;
        long v = strtol(argv[1], &end, 10);
        if (errno != 0 || end == argv[1] || *end != '\0' || v <= 0) {
            fprintf(stderr, "Invalid numeric argument: %s\n", argv[1]);
            return 1;
        }
        n = (int)v;
    } else {
        /* read from stdin (no prompt) so scripts can pipe input */
        if (scanf("%d", &n) != 1 || n <= 0) {
            fprintf(stderr, "Invalid input on stdin\n");
            return 1;
        }
    }
    
    int a[n][n];
    int num = 1;
    
    // Fill the matrix diagonally
    for (int s = 0; s <= 2*(n-1); ++s) {
        if ((s & 1) == 0) {  // Even diagonals: top-left to bottom-right
            for (int r = 0; r < n; ++r) {
                int c = s - r;
                if (c >= 0 && c < n) {
                    a[r][c] = num++;
                }
            }
        } else {  // Odd diagonals: bottom-right to top-left
            for (int r = n-1; r >= 0; --r) {
                int c = s - r;
                if (c >= 0 && c < n) {
                    a[r][c] = num++;
                }
            }
        }
    }
    
    // Print the matrix
    printf("\nDiagonal Pattern (%dx%d):\n", n, n);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            printf("%d%c", a[i][j], j+1==n ? '\n' : ' ');
        }
    }
    
    return 0;
}