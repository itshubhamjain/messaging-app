//
//  ViewController.h
//  firstapp
//
//  Created by Shubham Jain on 1/5/17.
//  Copyright © 2017 Shubham Jain. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
{
    IBOutlet UITextField *dispInp;
    IBOutlet UILabel *dispOutt;
    IBOutlet UITextView *displayOut;
    IBOutlet UITextField *destination;
    IBOutlet UILabel *display1;
    IBOutlet UITextField *contactSelf;
}
- (IBAction)sentMess:(id)sender;

@property(strong,nonatomic) UITextField *dispInp;
@property(strong,nonatomic) UITextView *displayOut;
@property(strong,nonatomic) UILabel *display1;
@property(strong,nonatomic) UITextField *destination;
@property(strong,nonatomic) UITextField *contactSelf;

@end

