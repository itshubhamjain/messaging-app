//
//  ViewController.m
//  firstapp
//
//  Created by Shubham Jain on 1/5/17.
//  Copyright © 2017 Shubham Jain. All rights reserved.
//

#import "ViewController.h"


@interface ViewController ()
-(void)threadRecieve:(NSString *)contact;
@end

@implementation ViewController

@synthesize dispInp;
@synthesize displayOut;
@synthesize display1;
@synthesize destination;
@synthesize contactSelf;


- (void)viewDidLoad {

    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}






- (void)viewDidAppear:(BOOL)animated {
    
}
- (void)threadRecieve:(NSString *)contact{
    
    NSString *urlRecieve =[NSString stringWithFormat:@"http://localhost:8080/messapp/webapi/recieve?destination=%@",contact];
    NSMutableURLRequest *request_1 = [[NSMutableURLRequest alloc] init];
    [request_1 setHTTPMethod:@"GET"];
    [request_1 setURL:[NSURL URLWithString:urlRecieve]];
    NSError *error_1 = nil;
    NSHTTPURLResponse *responseCode_1 = nil;
    
    NSData *oResponseData_1 = [NSURLConnection sendSynchronousRequest:request_1 returningResponse:&responseCode_1 error:&error_1];
    NSString *next=[[NSString alloc] initWithData:oResponseData_1 encoding:NSUTF8StringEncoding];
    display1.text=[NSString stringWithFormat:@"%@%@",display1.text,next];
    [NSThread sleepForTimeInterval:3];

}





- (IBAction)sentMess:(id)sender {
    
    NSString *contact=contactSelf.text;
    NSString *urlPing  = [NSString stringWithFormat:@"http://localhost:8080/messapp/webapi/ping?source=%@",contact];
    NSMutableURLRequest *requestPing = [[NSMutableURLRequest alloc] init];
    [requestPing setHTTPMethod:@"GET"];
    [requestPing setURL:[NSURL URLWithString:urlPing]];
    NSThread* myThread = [[NSThread alloc] initWithTarget:self
                                                 selector:@selector(threadRecieve:)
                                                   object:contact];
    [myThread start];

   
    
    
    

    
    
    
    NSString *dispinp=dispInp.text;
    NSString *dest=destination.text;
     NSString *url  = [NSString stringWithFormat:@"http://localhost:8080/messapp/webapi/messages?source=%@&destination=%@&message=%@",contact,dispinp,dest];
    
    
    NSMutableURLRequest *request = [[NSMutableURLRequest alloc] init];
    [request setHTTPMethod:@"GET"];
    [request setURL:[NSURL URLWithString:url]];
    NSError *error = nil;
    NSHTTPURLResponse *responseCode = nil;
    
    NSData *oResponseData = [NSURLConnection sendSynchronousRequest:request returningResponse:&responseCode error:&error];
    
    display1.text=[[NSString alloc] initWithData:oResponseData encoding:NSUTF8StringEncoding];
    dispInp.text = @"";
    destination.text=nil;
    

    
    

    
    dispInp.text = @"";
    destination.text=nil;
}
@end
