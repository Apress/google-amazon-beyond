public class Factorial {
  
public int factorial (int N) throws Exception {
  if (N < 0 ) throw new Exception("no factorial for "+N);
  if (N < 2 ) return 1;
  return N * factorial(N-1);
}
}
