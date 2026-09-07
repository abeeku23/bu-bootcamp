#include <stdio.h>

/* Takes addresses, so it edits the caller's own variables. */
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Takes values, so it only edits its own local copies.
   The caller's variables are untouched: the function receives
   copies, not addresses, and the copies die when it returns. */
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x = 10, y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    int p = 5, q = 9;

    printf("\nBefore broken_swap: p = %d, q = %d\n", p, q);
    broken_swap(p, q);
    printf("After broken_swap:  p = %d, q = %d  (unchanged)\n", p, q);

    return 0;
}
