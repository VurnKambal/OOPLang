import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
    
    // Menu Panel Variables
    
    // Menu - Panel
    private JPanel menuPanel = new JPanel(new GridBagLayout());

    // Menu - Title Label
    private JLabel titleLabel = new JLabel();
    
    // Menu - Hotel Buttons
    private JButton hotel1Button = new JButton();
    private JButton hotel2Button = new JButton();
    private JButton hotel3Button = new JButton();
    private JButton hotel4Button = new JButton();
    private Font hotelNameFont = new Font("Arial Black", Font.PLAIN, 20);
    
    
    // Menu - Hotel Objects
    private Hotel hotel1, hotel2, hotel3, hotel4, selectedHotel;

    
    
    // Rental Panel Variables
    
    // Rental - Panel
    private JPanel rentalPanel = new JPanel(new GridBagLayout());
    
    // Rental - Title Label
    private JButton menuButton = new JButton();
    
    // Rental - Hotel
    private JLabel hotelNameLabel = new JLabel();
    private RoomType[] hotelRoomTypes;
    private String roomLabel;   
    
    // Rental - Room Types Radio Button Group
    private ButtonGroup roomTypeGroup = new ButtonGroup();
    private JRadioButton singleRadioButton = new JRadioButton();
    private JRadioButton doubleRadioButton = new JRadioButton();
    private JRadioButton deluxeRadioButton = new JRadioButton();
    private JRadioButton studioRadioButton = new JRadioButton();
    private JRadioButton suiteRadioButton = new JRadioButton();
    private Font roomTypeFont = new Font("Arial", Font.BOLD, 25);
    
    // Rental - Extras
    private JLabel extraLabel =new JLabel();
    private JCheckBox snacksCheckbox = new JCheckBox();
    private JCheckBox beveragesCheckbox = new JCheckBox();
    private JCheckBox membershipCheckbox = new JCheckBox();
    private JCheckBox bedsCheckbox = new JCheckBox();
    private JComboBox bedsComboBox;
    private Font extrasFont = new Font("Arial", Font.BOLD, 20);
    
    // Rental - Bill
    private JLabel billLabel = new JLabel();
    private JTextArea billTextArea = new JTextArea();
    private double roomPrice, snacksPrice, beveragesPrice, membershipPrice, bedsPrice, totalBill;
    private int snacksQty, beveragesQty, membershipQty, bedsQty;
    

    
    
    
    public MainFrame()
    {
        initHotels();
        initMenuPanel();
        initRentalPanel();
        initFrames();
    }
    
    
    public void initFrames()
    { 
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                   exitForm(e);
                }
            });
        
        setTitle("Hotel Room Rental");
        setResizable(false);
        setContentPane(menuPanel);
        pack();
    }
    

    private void initHotels()
    { 
        HotelRental.initHotelRental();
        Hotel[] hotels = HotelRental.getHotels();
        
        hotel1 = hotels[0];
        hotel2 = hotels[1];
        hotel3 = hotels[2];
        hotel4 = hotels[3];
        
    }
    
    
    // Menu Panel/Frame
    public void initMenuPanel()
    {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        // Gap
        gridConstraints.insets = new Insets(20,20,0,20);
        
        titleLabel.setText("Hotel Room Rental");
        titleLabel.setFont(new Font("Arial Black", Font.PLAIN, 32));
        gridConstraints.gridwidth = 5;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        
        menuPanel.add(titleLabel, gridConstraints);
        
        // Size
        gridConstraints.ipadx = 20;
        gridConstraints.ipady = 40;
                
        // Hotel 1 Button
        gridConstraints.insets.set(10,40,10,10);
        hotel1Button.setFont(hotelNameFont);
        hotel1Button.setText(hotel1.getName());
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        menuPanel.add(hotel1Button, gridConstraints);
        
        hotel1Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                hotel1ButtonActionPerformed(e);
            }
        });
        
        
        // Hotel 2 Button
        gridConstraints.insets.set(10,10,10,10);
        hotel2Button.setFont(hotelNameFont);
        hotel2Button.setText(hotel2.getName());
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        menuPanel.add(hotel2Button, gridConstraints);
        
        hotel2Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                hotel2ButtonActionPerformed(e);
            }
        });
        
        
        // Hotel 3 Button
        gridConstraints.insets.set(10,40,30,10);
        hotel3Button.setFont(hotelNameFont);
        hotel3Button.setText(hotel3.getName());
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        menuPanel.add(hotel3Button, gridConstraints);
        
        hotel3Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                hotel3ButtonActionPerformed(e);
            }
        });
        
        
        // Hotel 4 Button
        gridConstraints.insets.set(10,10,30,10);
        hotel4Button.setFont(hotelNameFont);
        hotel4Button.setText(hotel4.getName());
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        menuPanel.add(hotel4Button, gridConstraints);
        
        hotel4Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                hotel4ButtonActionPerformed(e);
            }
        });
        

    }
    
    
    // Rental Panel/Frame 
    private void initRentalPanel()
    {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        menuButton.setText("Menu");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = gridConstraints.FIRST_LINE_START;
        gridConstraints.insets = new Insets(10,10,0,10);
        rentalPanel.add(menuButton, gridConstraints);
        
        menuButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                menuButtonActionPerformed(e);
            }
        });
        
        
        gridConstraints.anchor = gridConstraints.CENTER;
        gridConstraints.insets.set(0,0,0,0);
        
        // Hotel Name Label
        hotelNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 50));
        hotelNameLabel.setText("Hotel    ");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 3;
        rentalPanel.add(hotelNameLabel, gridConstraints);
        
        gridConstraints.gridwidth = 1;
        
        // Room Types
        gridConstraints.anchor = gridConstraints.WEST;
        gridConstraints.insets.set(0,10,0,0);
        
        // Room Type - Single Radio Button
        roomTypeGroup.add(singleRadioButton);
        singleRadioButton.setEnabled(false);
        singleRadioButton.setFont(roomTypeFont);
        singleRadioButton.setText("Single");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        rentalPanel.add(singleRadioButton, gridConstraints);
        
        singleRadioButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                singleRadioButtonActionPerformed(e);
            }
        });
        
        
        // Room Type - Double Radio Button
        roomTypeGroup.add(doubleRadioButton);
        doubleRadioButton.setEnabled(false);
        doubleRadioButton.setFont(roomTypeFont);
        doubleRadioButton.setText("Double");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        rentalPanel.add(doubleRadioButton, gridConstraints);
        
        doubleRadioButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                doubleRadioButtonActionPerformed(e);
            }
        });
        
        
        // Room Type - Deluxe Radio Button    
        roomTypeGroup.add(deluxeRadioButton);
        deluxeRadioButton.setEnabled(false);
        deluxeRadioButton.setFont(roomTypeFont);
        deluxeRadioButton.setText("Deluxe");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        rentalPanel.add(deluxeRadioButton, gridConstraints);
        
        deluxeRadioButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                deluxeRadioButtonActionPerformed(e);
            }
        });
        
        
        // Room Type - Studio Radio Button
        roomTypeGroup.add(studioRadioButton);
        studioRadioButton.setEnabled(false);
        studioRadioButton.setText("Studio");
        studioRadioButton.setFont(roomTypeFont);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        rentalPanel.add(studioRadioButton, gridConstraints);
        
        studioRadioButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                studioRadioButtonActionPerformed(e);
            }
        });
        
        
        // Room Type - Suite Radio Button
        roomTypeGroup.add(suiteRadioButton);
        suiteRadioButton.setEnabled(false);
        suiteRadioButton.setFont(roomTypeFont);
        suiteRadioButton.setText("Suite");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        rentalPanel.add(suiteRadioButton, gridConstraints);
        
        suiteRadioButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                suiteRadioButtonActionPerformed(e);
            }
        });
        
        
        
        // Extras
        gridConstraints.insets.set(0, 50, 0, 0);
        extraLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
        extraLabel.setText("Extra");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 2;
        rentalPanel.add(extraLabel, gridConstraints);
        
        // Extras - Snacks Checkbox
        snacksCheckbox.setEnabled(false);
        snacksCheckbox.setFont(extrasFont);
        snacksCheckbox.setText("Snacks");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        rentalPanel.add(snacksCheckbox, gridConstraints);
        
        snacksCheckbox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                snacksCheckboxActionPerformed(e);
            }
        });
        
        
        // Extras - Beverages Checkbox
        beveragesCheckbox.setEnabled(false);
        beveragesCheckbox.setFont(extrasFont);
        beveragesCheckbox.setText("Beverages");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        rentalPanel.add(beveragesCheckbox, gridConstraints);
        
        beveragesCheckbox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                beveragesCheckboxActionPerformed(e);
            }
        });
        
        
        // Extras - Membership Checkbox
        membershipCheckbox.setEnabled(false);
        membershipCheckbox.setFont(extrasFont);
        membershipCheckbox.setText("Membership");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        gridConstraints.gridwidth = 2;
        rentalPanel.add(membershipCheckbox, gridConstraints);
        
        membershipCheckbox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                membershipCheckboxActionPerformed(e);
            }
        });
        
        
        // Extras - Beds Checkbox
        bedsCheckbox.setEnabled(false);
        bedsCheckbox.setFont(extrasFont);
        bedsCheckbox.setText("Beds");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.gridwidth = 1;
        rentalPanel.add(bedsCheckbox, gridConstraints);
        
        bedsCheckbox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                bedsCheckboxActionPerformed(e);
            }
        });
        
        // Extras - Beds ComboBox
        gridConstraints.insets.set(0,10,0,0);
        bedsComboBox = new JComboBox(new Object[] {1, 2, 3});
        bedsComboBox.setEnabled(false);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 6;
        gridConstraints.gridwidth = 1;
        gridConstraints.ipadx = 10;
        rentalPanel.add(bedsComboBox, gridConstraints);
        
        bedsComboBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                bedsComboBoxActionPerformed(e);
            }
        });
        
        
        gridConstraints.insets.set(0,10,20,20);
        
        // Bill - Label
        gridConstraints.anchor = gridConstraints.SOUTH;
        billLabel.setFont(new Font("Arial", Font.BOLD, 40));
        billLabel.setText("Bill");
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        rentalPanel.add(billLabel, gridConstraints);  
        
        gridConstraints.anchor = gridConstraints.CENTER;
        
        // Bill - TextArea
        billTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        billTextArea.setColumns(15);
        billTextArea.setRows(10);
        billTextArea.setEditable(false);
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 6;
        rentalPanel.add(billTextArea, gridConstraints);  
        
    }
    

    
    
    // Action Handlers
    
    // Menu Panel
    
    // Menu - Hotel Buttons
    public void hotel1ButtonActionPerformed(ActionEvent e)
    {
        hotelButtonsActionPerformed(e, hotel1);
    }
    
    public void hotel2ButtonActionPerformed(ActionEvent e)
    {
        hotelButtonsActionPerformed(e, hotel2);
    }
    
    public void hotel3ButtonActionPerformed(ActionEvent e)
    {
        hotelButtonsActionPerformed(e, hotel3);
    }
    
    public void hotel4ButtonActionPerformed(ActionEvent e)
    {
        hotelButtonsActionPerformed(e, hotel4);
    }
    
    public void hotelButtonsActionPerformed(ActionEvent e, Hotel selectedHotel)
    {
        this.selectedHotel = selectedHotel;
        hotelNameLabel.setText(selectedHotel.getName());
        setContentPane(rentalPanel);
        pack(); 
        initButtons();
        initPrice();
    }
    
    
    // Rental Panel
    // Rental - Menu Button
    public void menuButtonActionPerformed(ActionEvent e)
    {
        setContentPane(menuPanel);
        pack();
    }
    
    // Rental - Single Radio Button
    private void singleRadioButtonActionPerformed(ActionEvent e) 
    {
        roomTypeRadioButtonsActionPerformed(e, "Single");
    }
    
    // Rental - Double Radio Button
    private void doubleRadioButtonActionPerformed(ActionEvent e) 
    {
        roomTypeRadioButtonsActionPerformed(e, "Double");
    }
    
    // Rental - Deluxe Radio Button
    private void deluxeRadioButtonActionPerformed(ActionEvent e) 
    {
        roomTypeRadioButtonsActionPerformed(e, "Deluxe");
    }
    
    // Rental - Studio Radio Button
    private void studioRadioButtonActionPerformed(ActionEvent e)
    {
        roomTypeRadioButtonsActionPerformed(e, "Studio");
    }
    
    // Rental - Suite Radio Button
    private void suiteRadioButtonActionPerformed(ActionEvent e)
    {
        roomTypeRadioButtonsActionPerformed(e, "Suite");
    }
    
    // Rental - Room Types Radio Buttons
    private void roomTypeRadioButtonsActionPerformed(ActionEvent e, String roomTypeLabel)
    {
        labelRoomPrice(roomTypeLabel);
        enableExtras();
        updateBillTextArea();
    }

    
    // Rental - Snacks Checkbox
    private void snacksCheckboxActionPerformed(ActionEvent e)
    {
        if (snacksCheckbox.isSelected())
        {
            this.snacksQty = 1;
        }
        else
        {
            this.snacksQty = 0;
        }
        updateBillTextArea();
    }
    
    // Rental - Beverages Checkbox
    private void beveragesCheckboxActionPerformed(ActionEvent e)
    {
        if (beveragesCheckbox.isSelected())
        {
            this.beveragesQty = 1;
        }
        else
        {
            this.beveragesQty = 0;
        }
        updateBillTextArea();
    }
    
    // Rental - Membership Checkbox
    private void membershipCheckboxActionPerformed(ActionEvent e)
    {
        if (membershipCheckbox.isSelected())
        {
            this.membershipQty = 1;
        }
        else
        {
            this.membershipQty = 0;
        }
        updateBillTextArea();
    }
    
    // Rental - Beds Checkbox
    private void bedsCheckboxActionPerformed(ActionEvent e)
    {
        if (bedsCheckbox.isSelected())
        {
            bedsComboBox.setEnabled(true);
            bedsQty = Integer.parseInt(bedsComboBox.getSelectedItem().toString());
        }
        else
        {
            bedsQty = 0;
            bedsComboBox.setEnabled(false);
            bedsComboBox.setSelectedIndex(0);
            
        }
        updateBillTextArea();
    }
    
    // Rental - Beds Checkbox
    private void bedsComboBoxActionPerformed(ActionEvent e) 
    {
        if (bedsComboBox.isEnabled())
        {
            this.bedsQty = Integer.parseInt(bedsComboBox.getSelectedItem().toString());
        }
        else
        {
            this.bedsQty = 0;
        }
        updateBillTextArea();
    }
    
    
    public void exitForm(WindowEvent e)
    {
        JFrame f;
        f = new JFrame();
        exitProgram(f);
    }
    
    public void exitProgram(JFrame f)
    {
        JOptionPane.showMessageDialog(f, "Thank you for using the\nHotel Room Rental Application", "Exiting...", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void updateBillTextArea()
    {
        this.totalBill = roomPrice +
                        (snacksPrice * snacksQty) +
                        (beveragesPrice * beveragesQty) +
                        (membershipPrice * membershipQty) +
                        (bedsPrice * bedsQty);
        
        billTextArea.setText("" + roomLabel + " Room : $ " + roomPrice + " \n\n" +
                             "Extras\n" +
                             "Snacks            : $ " + (snacksPrice * snacksQty) + "\n" +
                             "Beverages      : $ " + (beveragesPrice * beveragesQty) + "\n" +
                             "Membership  : $ " + (membershipPrice * membershipQty) + "\n" +
                             "Beds               : $ " + (bedsPrice * bedsQty) + " \n\n" +
                             "Total Bill  : $ " + totalBill);
        

    }
    
    private void initButtons()
    {
        RoomType[] hotelRoomTypes = selectedHotel.getRoomTypes();
        this.hotelRoomTypes = hotelRoomTypes;
        for (RoomType room : hotelRoomTypes)
        {
            String roomType = room.getLabel();
            switch (roomType)
            {
                case "Single":
                    singleRadioButton.setEnabled(true);
                    break;
                   
                case "Double":
                    doubleRadioButton.setEnabled(true);
                    break;
                
                case "Deluxe":
                    deluxeRadioButton.setEnabled(true);
                    break;
                    
                case "Studio":
                    studioRadioButton.setEnabled(true);
                    break;
                    
                case "Suite":
                    suiteRadioButton.setEnabled(true);
                    break;
                    
            }
        }
    }

    
    private void enableExtras()
    {
        snacksCheckbox.setEnabled(true);
        beveragesCheckbox.setEnabled(true);
        membershipCheckbox.setEnabled(true);
        bedsCheckbox.setEnabled(true);
    }
    
    private void initPrice()
    {
        snacksPrice = selectedHotel.getSnacks().getPrice();
        beveragesPrice = selectedHotel.getBeverages().getPrice();
        membershipPrice = selectedHotel.getMembership().getPrice();
        bedsPrice = selectedHotel.getBeds().getPrice();
        
    }
    
    private void labelRoomPrice(String roomTypeLabel)
    {
        for (RoomType room : hotelRoomTypes)
        {
            if (room.getLabel().equals(roomTypeLabel))
            {
                this.roomLabel = room.getLabel();
                this.roomPrice = room.getPrice();
                return;
            }
        }
        
    }
    
    
    public static void main(String[] args)
    {
        new MainFrame().show();
    }
}
