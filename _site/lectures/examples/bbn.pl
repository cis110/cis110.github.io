#!/usr/bin/perl -w

# Benedict Brown
#
# Read in BouncingBall1.java from stdin;
# write out BouncingBallN.java to stdout
# that animates n balls by duplicating variables
#
# Arguments: n - the desired number of balls
#
# Compilation: None (perl programs do not need to be compiled)
# Execution: perl bbn.pl 3 < BouncingBall1.java > BouncingBall3.java
#
# Perl Notes:
# -----------
# comments in perl begin with a # symbol
#
# variable names in perl must start with a $
# but they don't need to be declared
#
# perl does not require a class or main function
#
# Each program line has a comment with the equivelant java
# or an explanation of what the line does.

$n = $ARGV[0]; # int n = Integer.parseInt(args[0]);

while (<STDIN>) { # while (!StdIn.isEmpty()) { String _ = StdIn.readLine();
    # fix program name
    s/BouncingBall1/BouncingBall$n/;   # replace "BouncingBall1" by "BouncingBall" + n in _

    # replicate all lines containing variable x0, y0, accel0
    if (/(x|y|(accel))0/) {            # if _ contains x0, y0, or accel0
        $line = $_;                    #   String line = _;
        for ($i = 0; $i < $n; $i++) {  #   for (int i = 0; i < n; i++) {
            $_ = $line;                #     _ = line;
            s/(x|y|(accel))0/$1$i/g;   #     replace "x0", "y0", "accel0" in _ with "x" + i, ...
            print $_;                  #     System.out.println(_);
        }                              #   }
    } else {                           # } else {
        # line doesn't contain x0, y0, or accel0
        print $_;                      #   System.out.println(_);
    }                                  # }
}
