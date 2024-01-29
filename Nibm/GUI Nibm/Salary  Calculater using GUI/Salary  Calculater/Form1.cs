using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Salary__Calculater
{
    public partial class FormCalculateNetSalary : Form
    {
        public FormCalculateNetSalary()
        {
            InitializeComponent();
        }

        private void buttonCal_Click(object sender, EventArgs e)
        {
            string BSal=textBox1.Text;
            string Allow=textBox2.Text;
            
            double bs =Convert.ToDouble (BSal) ;
            double ay= Convert.ToDouble (Allow) ;
            double Epf = bs*0.1;
            double NetS = bs + ay  - Epf;
            textBox3.Text = Convert.ToString(NetS);

        }

        
        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            

        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            textBox1.Text = string.Empty;
            textBox2.Text = string.Empty;
            textBox3.Text = string.Empty;
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
