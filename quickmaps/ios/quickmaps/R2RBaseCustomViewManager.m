#import "R2RBaseCustomViewManager.h"
#import "R2RBaseCustomView.h"

@implementation R2RBaseCustomViewManager
RCT_EXPORT_MODULE()

- (UIView *)view
{
    return [R2RBaseCustomView new];
}

@end
