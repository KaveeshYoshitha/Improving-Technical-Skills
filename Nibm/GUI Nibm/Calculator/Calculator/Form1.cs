using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void buttonCalculate_Click(object sender, EventArgs e)
        {
            string num1=textBoxNumber1.Text;
            string num2=textBoxNumber2.Text;
            string ope=textBoxOperator.Text;

            double x = Convert.ToDouble(num1);
            double y = Convert.ToDouble(num2);
            double result = 0;

            switch (ope)
            {
                case "+": 
                    result = x+y; break;
                case "-":
                    result = x-y; break;
                case "*":
                    result = x*y; break;
             
                case "/":
                    result = x/y; break;
            }

            MessageBox.Show("Your result is" + result);
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            textBoxNumber1.Text = string.Empty;
            textBoxNumber2.Text = string.Empty;
            textBoxOperator.Text = string.Empty;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
