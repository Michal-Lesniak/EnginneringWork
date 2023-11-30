export interface TokenData {
  sub: string,
  iat: number,
  exp: number,
  roles: string[],
  userId: number,
}
