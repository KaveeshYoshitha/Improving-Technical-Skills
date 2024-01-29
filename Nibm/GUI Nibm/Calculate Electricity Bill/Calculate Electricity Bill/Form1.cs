using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculate_Electricity_Bill
{
    public partial class FormECBill : Form
    {
        public FormECBill()
        {
            InitializeComponent();
            comboBoxCusType.SelectedIndex = 0;
        }

        private void comboBoxCusType_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void textBoxUnits_TextChanged(object sender, EventArgs e)
        {
        }

        private void buttonCalculate_Click(object sender, EventArgs e)
        {
            int selectIndex = comboBoxCusType.SelectedIndex;
            string val = comboBoxCusType.SelectedIndex.ToString();
            string uni = textBoxUnits.Text;
            double tot;
            double rent;
            int value = Convert.ToInt32(val);
            int unit= Convert.ToInt32(uni);

            if (selectIndex == 0) {
                MessageBox.Show("Select a valid customer type");
            }
            else if (selectIndex == 1)
            {
                rent = 200.00;
                if (unit <= 100)
                {
                    tot = 500 + rent;
                    textBoxTotal.Text=Convert.ToString(tot);

                }
                else if (unit >100)
                {
                    tot = (unit - 100) * 20 + 500 + rent;
                    textBoxTotal.Text = Convert.ToString(tot);
                }
            }
            else if (selectIndex == 2) {
                rent = 600.00;
                if (unit <= 100)
                {
                    tot = 800 + rent;
                    textBoxTotal.Text = Convert.ToString(tot);

                }
                else if (unit > 100)
                {
                    tot = (unit - 100) * 50 + 800 + rent;
                    textBoxTotal.Text = Convert.ToString(tot);
                }
            }

        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
           textBoxUnits.Text=string.Empty;
           textBoxTotal.Text=string.Empty;
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
