package com.googlecode.cceb.chemistry;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.googlecode.cceb.math.Fraction;
import com.googlecode.cceb.math.Matrix;


public class reaction
{

        private ArrayList<Compound> reactants, products;

        public Formula(String input) {
                reactants = new ArrayList<Compound>();
                products = new ArrayList<Compound>();
                StringTokenizer st = new StringTokenizer(input);

                boolean isReactant = true; 
                while (st.hasMoreTokens()) {
                        String cp = st.nextToken();
                        if (cp.equals("=")) 
                                isReactant = false;
                        } else if (cp.equals("+")) {
                               
                        } else {
                               
                                (isReactant ? reactants : products).add(new Compound(cp));
                        }
                }
        }

        public String balance() throws InvalidElementException,
                        InvalidFormulaException {
                double[][] values;
                Matrix solver = new Matrix();
                int numcp = reactants.size() + products.size();
               
                ArrayList<Element> distel = new ArrayList<Element>();
                for (int i = 0; i < reactants.size(); i++) {
                        List<Element> temp = reactants.get(i).RAMIREZ_getConstituents();
                        for (int j = 0; j < temp.size(); j++) {
                                if (!distel.contains(temp.get(j))) {
                                        distel.add(temp.get(j));
                                }
                        }
                }
                for (int i = 0; i < products.size(); i++) {
                        List<Element> temp = products.get(i).RAMIREZ_getConstituents();
                        for (int j = 0; j < temp.size(); j++) {
                                if (!distel.contains(temp.get(j))) {
                                        distel.add(temp.get(j));
                                }
                        }
                        
                }

                values = new double[numcp - 1][numcp];

                ArrayList<Compound> allcomp = new ArrayList();
                allcomp.addAll(reactants);
                allcomp.addAll(products);
                /*
                 * convert to matrix: count compound (if there are 4 compounds: 3
                 * equations in order to know how many equations to make (n-1))
                 */
                for (int i = 0; i < numcp - 1; i++) {
                        for (int j = 0; j < numcp; j++) {
                                if (i + 1 > distel.size()) {
                                        break;
                                }
                                values[i][j] = allcomp.get(j).getElementCount(distel.get(i));

                        }
                }
                solver.setValues(values);
                
                solver.rref();
                values = solver.getValues();
                
                double[] balanced = new double[numcp];
                for (int i = 0; i < numcp - 1; i++) {
                        balanced[i] = values[i][numcp - 1];
                }
               
                for (int i = allcomp.size() - 2; i > reactants.size() - 1; i--) {
                        balanced[i] *= -1;
                }
                balanced[numcp - 1] = 1;

              
                Fraction[] b = new Fraction[numcp];
                for (int i = 0; i < numcp; i++) {
                        b[i] = new Fraction(balanced[i]);
                }
                int[] b1 = new int[numcp];
                int m = b[0].cmult(b);
                for (int i = 0; i < numcp; i++) {
                        b[i].mult(m);
                        b1[i] = b[i].getNumerator();
                }

                /*
                 * lcm/gcd stuff
                 */
                b1 = lcm(b1);
                /*
                 * Creates String
                 */
                String[] a = new String[numcp];
                String answer = new String();

                for (int i = 0; i < reactants.size(); i++) {
                        if ((double) b1[i] == 1) {
                                a[i] = reactants.get(i).toString();
                        } else {
                                a[i] = b1[i] + reactants.get(i).toString();
                        }
                }
                for (int i = 0; i < products.size(); i++) {
                        if (b1[i + reactants.size()] == 1) {
                                a[i + reactants.size()] = products.get(i).toString();
                        } else {
                                a[i + reactants.size()] = b1[i + reactants.size()]
                                                + products.get(i).toString();
                        }
                }
                for (int i = 0; i < numcp; i++) {
                        if (i != reactants.size() - 1 && i != reactants.size()) {
                                if (i == 0) {
                                        answer = answer.concat(a[i]);
                                } else {
                                        answer = answer.concat(" + ");
                                        answer = answer.concat(a[i]);
                                }
                        } else {
                                if (i == reactants.size() - 1) {
                                        answer = answer.concat(" + ");
                                        answer = answer.concat(a[i]);
                                        answer = answer.concat(" = ");
                                } else {
                                        answer = answer.concat(a[i]);
                                }
                        }
                }

                return answer;

                
        }

        public String toString() {
                return reactants.toString() + products.toString();
        }

        private int[] lcm(int[] a) {
                int g = gcd(a);
                if (g == 1) {
                        return a;
                } else {
                        for (int i = 0; i < a.length; i++) {
                                a[i] /= g;
                        }
                        return lcm(a);
                }
        }

        private final int gcd(int[] x) {
                if (x.length < 2) {
                        throw new Error("Do not use this method if there are less than"
                                        + " two numbers.");
                }
                int tmp = gcd(x[x.length - 1], x[x.length - 2]);
                for (int i = x.length - 3; i >= 0; i--) {
                        if (x[i] < 0) {
                                throw new IllegalArgumentException("Cannot compute the least "
                                                + "common multiple of " + "several numbers where "
                                                + "one, at least," + "is negative.");
                        }
                        tmp = gcd(tmp, x[i]);
                }
                return tmp;
        }

      
        private final int gcd(int x1, int x2) {
                if (x1 < 0 || x2 < 0) {
                        throw new IllegalArgumentException("Cannot compute the GCD "
                                        + "if one integer is negative.");
                }
                int a, b, g, z;

                if (x1 > x2) {
                        a = x1;
                        b = x2;
                } else {
                        a = x2;
                        b = x1;
                }

                if (b == 0)
                        return 0;

                g = b;
                while (g != 0) {
                        z = a % g;
                        a = g;
                        g = z;
                }
                return a;
        }

}
 


