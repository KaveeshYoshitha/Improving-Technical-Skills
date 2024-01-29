namespace Salary__Calculater
{
    partial class FormCalculateNetSalary
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelBasicSal = new System.Windows.Forms.Label();
            this.labelAllowance = new System.Windows.Forms.Label();
            this.labelNetSal = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.buttonCal = new System.Windows.Forms.Button();
            this.buttonClear = new System.Windows.Forms.Button();
            this.buttonExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelBasicSal
            // 
            this.labelBasicSal.AutoSize = true;
            this.labelBasicSal.Location = new System.Drawing.Point(59, 51);
            this.labelBasicSal.Name = "labelBasicSal";
            this.labelBasicSal.Size = new System.Drawing.Size(83, 16);
            this.labelBasicSal.TabIndex = 0;
            this.labelBasicSal.Text = "Basic Salary";
            // 
            // labelAllowance
            // 
            this.labelAllowance.AutoSize = true;
            this.labelAllowance.Location = new System.Drawing.Point(59, 168);
            this.labelAllowance.Name = "labelAllowance";
            this.labelAllowance.Size = new System.Drawing.Size(69, 16);
            this.labelAllowance.TabIndex = 1;
            this.labelAllowance.Text = "Allowance";
            // 
            // labelNetSal
            // 
            this.labelNetSal.AutoSize = true;
            this.labelNetSal.Location = new System.Drawing.Point(59, 285);
            this.labelNetSal.Name = "labelNetSal";
            this.labelNetSal.Size = new System.Drawing.Size(70, 16);
            this.labelNetSal.TabIndex = 2;
            this.labelNetSal.Text = "Net Salary";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(321, 51);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(367, 22);
            this.textBox1.TabIndex = 3;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(321, 168);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(367, 22);
            this.textBox2.TabIndex = 4;
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(321, 282);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(367, 22);
            this.textBox3.TabIndex = 5;
            this.textBox3.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // buttonCal
            // 
            this.buttonCal.Location = new System.Drawing.Point(62, 363);
            this.buttonCal.Name = "buttonCal";
            this.buttonCal.Size = new System.Drawing.Size(145, 35);
            this.buttonCal.TabIndex = 6;
            this.buttonCal.Text = "Calculate";
            this.buttonCal.UseVisualStyleBackColor = true;
            this.buttonCal.Click += new System.EventHandler(this.buttonCal_Click);
            // 
            // buttonClear
            // 
            this.buttonClear.Location = new System.Drawing.Point(321, 363);
            this.buttonClear.Name = "buttonClear";
            this.buttonClear.Size = new System.Drawing.Size(145, 35);
            this.buttonClear.TabIndex = 7;
            this.buttonClear.Text = "Clear";
            this.buttonClear.UseVisualStyleBackColor = true;
            this.buttonClear.Click += new System.EventHandler(this.buttonClear_Click);
            // 
            // buttonExit
            // 
            this.buttonExit.Location = new System.Drawing.Point(543, 363);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Size = new System.Drawing.Size(145, 35);
            this.buttonExit.TabIndex = 8;
            this.buttonExit.Text = "Exit";
            this.buttonExit.UseVisualStyleBackColor = true;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // FormCalculateNetSalary
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1074, 450);
            this.Controls.Add(this.buttonExit);
            this.Controls.Add(this.buttonClear);
            this.Controls.Add(this.buttonCal);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.labelNetSal);
            this.Controls.Add(this.labelAllowance);
            this.Controls.Add(this.labelBasicSal);
            this.Name = "FormCalculateNetSalary";
            this.Text = "Calcu;ate Net Salary";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelBasicSal;
        private System.Windows.Forms.Label labelAllowance;
        private System.Windows.Forms.Label labelNetSal;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Button buttonCal;
        private System.Windows.Forms.Button buttonClear;
        private System.Windows.Forms.Button buttonExit;
    }
}

