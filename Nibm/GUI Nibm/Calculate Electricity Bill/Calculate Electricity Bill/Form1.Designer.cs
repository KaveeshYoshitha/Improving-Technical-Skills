namespace Calculate_Electricity_Bill
{
    partial class FormECBill
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
            this.labelCusType = new System.Windows.Forms.Label();
            this.labelUnits = new System.Windows.Forms.Label();
            this.labelTotal = new System.Windows.Forms.Label();
            this.textBoxUnits = new System.Windows.Forms.TextBox();
            this.textBoxTotal = new System.Windows.Forms.TextBox();
            this.comboBoxCusType = new System.Windows.Forms.ComboBox();
            this.buttonCalculate = new System.Windows.Forms.Button();
            this.buttonClear = new System.Windows.Forms.Button();
            this.buttonExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelCusType
            // 
            this.labelCusType.AutoSize = true;
            this.labelCusType.Location = new System.Drawing.Point(95, 54);
            this.labelCusType.Name = "labelCusType";
            this.labelCusType.Size = new System.Drawing.Size(99, 16);
            this.labelCusType.TabIndex = 0;
            this.labelCusType.Text = "Customer Type";
            // 
            // labelUnits
            // 
            this.labelUnits.AutoSize = true;
            this.labelUnits.Location = new System.Drawing.Point(95, 162);
            this.labelUnits.Name = "labelUnits";
            this.labelUnits.Size = new System.Drawing.Size(37, 16);
            this.labelUnits.TabIndex = 1;
            this.labelUnits.Text = "Units";
            // 
            // labelTotal
            // 
            this.labelTotal.AutoSize = true;
            this.labelTotal.Location = new System.Drawing.Point(95, 268);
            this.labelTotal.Name = "labelTotal";
            this.labelTotal.Size = new System.Drawing.Size(38, 16);
            this.labelTotal.TabIndex = 2;
            this.labelTotal.Text = "Total";
            // 
            // textBoxUnits
            // 
            this.textBoxUnits.Location = new System.Drawing.Point(260, 156);
            this.textBoxUnits.Name = "textBoxUnits";
            this.textBoxUnits.Size = new System.Drawing.Size(425, 22);
            this.textBoxUnits.TabIndex = 3;
            this.textBoxUnits.TextChanged += new System.EventHandler(this.textBoxUnits_TextChanged);
            // 
            // textBoxTotal
            // 
            this.textBoxTotal.Location = new System.Drawing.Point(260, 262);
            this.textBoxTotal.Name = "textBoxTotal";
            this.textBoxTotal.Size = new System.Drawing.Size(425, 22);
            this.textBoxTotal.TabIndex = 4;
            // 
            // comboBoxCusType
            // 
            this.comboBoxCusType.FormattingEnabled = true;
            this.comboBoxCusType.Items.AddRange(new object[] {
            "Select customer type",
            "Domestic",
            "Business "});
            this.comboBoxCusType.Location = new System.Drawing.Point(260, 51);
            this.comboBoxCusType.Name = "comboBoxCusType";
            this.comboBoxCusType.Size = new System.Drawing.Size(425, 24);
            this.comboBoxCusType.TabIndex = 5;
            this.comboBoxCusType.SelectedIndexChanged += new System.EventHandler(this.comboBoxCusType_SelectedIndexChanged);
            // 
            // buttonCalculate
            // 
            this.buttonCalculate.Location = new System.Drawing.Point(98, 347);
            this.buttonCalculate.Name = "buttonCalculate";
            this.buttonCalculate.Size = new System.Drawing.Size(129, 52);
            this.buttonCalculate.TabIndex = 6;
            this.buttonCalculate.Text = "Calculate";
            this.buttonCalculate.UseVisualStyleBackColor = true;
            this.buttonCalculate.Click += new System.EventHandler(this.buttonCalculate_Click);
            // 
            // buttonClear
            // 
            this.buttonClear.Location = new System.Drawing.Point(336, 347);
            this.buttonClear.Name = "buttonClear";
            this.buttonClear.Size = new System.Drawing.Size(129, 52);
            this.buttonClear.TabIndex = 7;
            this.buttonClear.Text = "Clear";
            this.buttonClear.UseVisualStyleBackColor = true;
            this.buttonClear.Click += new System.EventHandler(this.buttonClear_Click);
            // 
            // buttonExit
            // 
            this.buttonExit.Location = new System.Drawing.Point(556, 347);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Size = new System.Drawing.Size(129, 52);
            this.buttonExit.TabIndex = 8;
            this.buttonExit.Text = "Exit";
            this.buttonExit.UseVisualStyleBackColor = true;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // FormECBill
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.buttonExit);
            this.Controls.Add(this.buttonClear);
            this.Controls.Add(this.buttonCalculate);
            this.Controls.Add(this.comboBoxCusType);
            this.Controls.Add(this.textBoxTotal);
            this.Controls.Add(this.textBoxUnits);
            this.Controls.Add(this.labelTotal);
            this.Controls.Add(this.labelUnits);
            this.Controls.Add(this.labelCusType);
            this.Name = "FormECBill";
            this.Text = "Electricity Bill Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelCusType;
        private System.Windows.Forms.Label labelUnits;
        private System.Windows.Forms.Label labelTotal;
        private System.Windows.Forms.TextBox textBoxUnits;
        private System.Windows.Forms.TextBox textBoxTotal;
        private System.Windows.Forms.ComboBox comboBoxCusType;
        private System.Windows.Forms.Button buttonCalculate;
        private System.Windows.Forms.Button buttonClear;
        private System.Windows.Forms.Button buttonExit;
    }
}

