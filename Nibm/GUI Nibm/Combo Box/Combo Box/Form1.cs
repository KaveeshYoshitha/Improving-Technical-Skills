using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Combo_Box
{
    public partial class FormDropdown : Form
    {
        public FormDropdown()
        {
            InitializeComponent();
            comboBox1.SelectedIndex = 0;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonDisplay_Click(object sender, EventArgs e)
        {
            //reading the selected index from the combo box
            int selectindex = comboBox1.SelectedIndex;

            //reading the selected item value from the combo box
            string val=comboBox1.SelectedItem.ToString();

            MessageBox.Show("Selected index and value : " + selectindex +"" + val);
        }
    }
}
