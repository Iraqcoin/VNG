namespace * Common.ThriftInterface
struct User
{
  1:optional i32 Id,
  2:optional string username,
  3:optional string password,
  4:optional i32 visitor
}
service UserService
{
  User GetUser(1: string username);
  i32 UpdateVisitor(1: string username);
  User Increase(1: string username);
  bool CheckLogin(1: string username,2: string pword);
}