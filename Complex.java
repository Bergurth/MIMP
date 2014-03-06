/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package stv;

/**
 *
 * @author bergurth
 */


public class Complex
{
 private double re;
 private double im;

  public Complex () {
    this.re = 0;
    this.im = 0;
  }

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public Complex(Complex input) {
    this.re = input.getRe();
    this.im = input.getIm();
  }


  public void setRe(double re) {
    this.re = re;
  }

  public void setIm(double im) {
    this.im = im;
  }

   public double getRe() {
    return this.re;
  }

  public double getIm() {
    return this.im;
  }


   public Complex getConjugate() {
    return new Complex(this.re, this.im * (-1));
  }

    public Complex add(Complex op) {
    Complex result = new Complex();
    result.setRe(this.re + op.getRe());
    result.setIm(this.im + op.getIm());
    return result;
  }

  public Complex sub(Complex op) {
    Complex result = new Complex();
    result.setRe(this.re - op.getRe());
    result.setIm(this.im - op.getIm());
    return result;
  }

  public Complex mul(Complex op) {
    Complex result = new Complex();
    result.setRe(this.re * op.getRe() - this.im * op.getIm());
    result.setIm(this.re * op.getIm() + this.im * op.getRe());
    return result;
  }

  public Complex div(Complex op) {
    Complex result = new Complex(this);
    result = result.mul(op.getConjugate());
   double opNormSq = op.getRe()*op.getRe()+op.getIm()*op.getIm();
    result.setRe(result.getRe() / opNormSq);
    result.setIm(result.getIm() / opNormSq);
    return result;
  }

  public Complex fromPolar(double magnitude, double angle) {
    Complex result = new Complex();
    result.setRe(magnitude * Math.cos(angle));
    result.setIm(magnitude * Math.sin(angle));
    return result;
  }

  public double getNorm() {
    return Math.sqrt(this.re * this.re + this.im * this.im);
  }

  public double getAngle() {
    return Math.atan2(this.im, this.re);
  }

   public String toString() {
    if (this.re == 0) {
      if (this.im == 0) {
        return "0";
      } else {
        return (this.im + "i");
      }
    } else {
      if (this.im == 0) {
        return String.valueOf(this.re);
      } else if (this.im < 0) {
        return(this.re + " " + this.im + "i");
      } else {
        return(this.re + " +" + this.im + "i");
      }
    }
  }

    public static void main(String argv[]) {
    Complex a = new Complex(3, 4);
    Complex b = new Complex(1, -100);
    System.out.println(a.getNorm());
    System.out.println(b.getAngle());
    System.out.println(a.mul(b));
    System.out.println(a.div(b));
    System.out.println(a.div(b).mul(b));
  }

}
